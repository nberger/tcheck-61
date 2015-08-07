# TCHECK-61

Shows the difficulty in reproducing the issue [TCHECK-61](http://dev.clojure.org/jira/browse/TCHECK-61) because when there's a require of the missing ns somewhere else in the codebase, the error goes away.

This has probably to do with the fact that on :optimization level other than :none, the Google Closure compiler generates one single file with all the dependencies, so a namespace required in one namespace ends
being available in other namespaces that don't require it.

## How to reproduce?

1. Checkout the `test-fail` tag and run the tests:

        $ git checkout test-fail
        $ lein do clean, cljsbuild once test

    The test fails because there's only one test ns (`test.cljsinit.core-test`) which does not require `cljs.test.check`

2. Checkout the `test-ok` tag and run the tests:

        $ git checkout test-ok
        $ lein do clean, cljsbuild once test

    The test runs ok because there's an additional ns (`test.cljsinit.other-test`) which requires `cljs.test.check`, fixing the previous test.

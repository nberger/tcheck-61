(ns cljsinit.core-test
  (:require [cljs.test.check.generators :as gen]
            [cljs.test.check.cljs-test :refer-macros [defspec]]
            [cljs.test.check.properties :refer-macros [for-all]]))

(defspec almost-positive
  (for-all [i gen/pos-int]
    (>= i 0)))

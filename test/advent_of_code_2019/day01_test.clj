(ns advent-of-code-2019.day01-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2019.day01 :refer :all]))

(deftest fuel-calculation
  (testing "mass"
    (is (= (calculate-fuel 12) 2))
    (is (= (calculate-fuel 14) 2))
    (is (= (calculate-fuel 1969) 654))
    (is (= (calculate-fuel 100756) 33583))
    )
  )

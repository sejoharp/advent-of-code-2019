(ns advent-of-code-2019.day01-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2019.day01 :refer :all]))

(deftest fuel-calculation
  (testing "without fuel for fuel"
    (is (= (calculate-fuel 12) 2))
    (is (= (calculate-fuel 14) 2))
    (is (= (calculate-fuel 1969) 654))
    (is (= (calculate-fuel 100756) 33583))
    )
  (testing "with fuel for fuel"
    (is (= (fuel-for-modul 1969) 966))
    (is (= (fuel-for-modul 100756) 50346))
    )
  )

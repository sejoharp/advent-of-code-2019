(ns advent-of-code-2019.day04-test
  (:require [clojure.test :refer :all])
  (:require [advent-of-code-2019.day04 :refer :all]))

(deftest password-test
  (testing "detects numbers with two same digits"
    (is (= (twice-digit 11246543) true))
    (is (= (twice-digit 12335688) true))
    (is (= (twice-digit 12345678) false))
    )
  (testing "detects numbers with three same digits"
    (is (= (tripple-digit-with-double-digit 123444) false))
    (is (= (tripple-digit-with-double-digit 111122) true))
    (is (= (tripple-digit-with-double-digit 555558) false))
    (is (= (tripple-digit-with-double-digit 777777) false))
    )
  (testing "detects growing digits"
    (is (= (growing-digits 1234567) true))
    (is (= (growing-digits 11234567) true))
    (is (= (growing-digits 11231567) false))
    )
  )
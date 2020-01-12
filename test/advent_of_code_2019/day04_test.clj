(ns advent-of-code-2019.day04-test
  (:require [clojure.test :refer :all])
  (:require [advent-of-code-2019.day04 :refer :all]))

(deftest password-test
  (testing "detects numbers with two same digits"
    (is (= (twice-digit "11246543") true))
    (is (= (twice-digit "12335688") true))
    (is (= (twice-digit "12345678") false))
    )
  (testing "detects numbers with three same digits"
    (is (= (remove-illegal-digits ["123444"]) ["123"]))
    (is (= (remove-illegal-digits ["111122"]) ["22"]))
    (is (= (remove-illegal-digits ["555558"]) ["58"]))
    (is (= (remove-illegal-digits ["777777"]) [""]))
    )
  (testing "detects growing digits"
    (is (= (growing-digits "1234567") true))
    (is (= (growing-digits "11234567") true))
    (is (= (growing-digits "11231567") false))
    )
  )
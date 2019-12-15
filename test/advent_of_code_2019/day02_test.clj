(ns advent-of-code-2019.day02-test
  (:require [clojure.test :refer :all])
  (:require [advent-of-code-2019.day02 :refer :all]))

(deftest program-1202
  (testing "addition"
    (is (=
          (:input (calculate [1, 0, 0, 0] 0))
          [2, 0, 0, 0]))
    )
  (testing "multiplication"
    (is (=
          (:input (calculate [2, 3, 0, 3] 0))
          [2, 3, 0, 6]))
    )
  (testing "halt-method"
    (is (=
          (halt [99, 3, 0, 3] 0)
          {:finished true
           :input [99, 3, 0, 3]
           :start-position 1}))
    )
  (testing "halt"
    (is (=
          (:input (calculate [99, 3, 0, 3] 0))
          [99, 3, 0, 3]))
    )
  (testing "stepping"
    (is (=
          (run-program-code [2, 3, 0, 3, 99])
          {:input    [2, 3, 0, 6, 99]
           :finished true
           :start-position 5}))
    (is (=
          (run-program-code [2, 4, 4, 5, 99, 0])
          {:input    [2, 4, 4, 5, 99, 9801]
           :finished true
           :start-position 5}))
    (is (=
          (run-program-code [1, 1, 1, 4, 99, 5, 6, 0, 99])
          {:input    [30, 1, 1, 4, 2, 5, 6, 0, 99]
           :finished true
           :start-position 9})))
  (testing "restoring"
    (is (=
          restore-state
          [1, 12, 2, 3, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 10, 1, 19, 2, 9, 19, 23, 2, 13, 23, 27, 1, 6, 27, 31, 2, 6, 31, 35, 2, 13, 35, 39, 1, 39, 10, 43, 2, 43, 13, 47, 1, 9, 47, 51, 1, 51, 13, 55, 1, 55, 13, 59, 2, 59, 13, 63, 1, 63, 6, 67, 2, 6, 67, 71, 1, 5, 71, 75, 2, 6, 75, 79, 1, 5, 79, 83, 2, 83, 6, 87, 1, 5, 87, 91, 1, 6, 91, 95, 2, 95, 6, 99, 1, 5, 99, 103, 1, 6, 103, 107, 1, 107, 2, 111, 1, 111, 5, 0, 99, 2, 14, 0, 0])))
  )

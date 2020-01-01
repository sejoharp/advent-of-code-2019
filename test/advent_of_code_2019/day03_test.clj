(ns advent-of-code-2019.day03-test
  (:require [clojure.test :refer :all])
  (:require [advent-of-code-2019.day03 :refer :all]))

(deftest move-left-test
  (testing "calculates coordinates for moving left"
    (is (=
          (move-left [0, 0] 2)
          [[-1, 0] [-2, 0]])
        )
    (is (=
          (move-left [0, -2] 2)
          [[-1, -2] [-2, -2]])
        )
    (is (=
          (move-left [-3, -2] 2)
          [[-4, -2] [-5, -2]])
        )
    (is (=
          (to-coordinates [-3, -2] "L2")
          [[-4, -2] [-5, -2]])
        )
    )
  (testing "calculates coordinates for moving right"
    (is (=
          (move-right [0, 0] 2)
          [[1, 0] [2, 0]])
        )
    (is (=
          (to-coordinates [-3, -2] "R2")
          [[-2, -2] [-1, -2]])
        )
    )
  (testing "calculates coordinates for moving up"
    (is (=
          (move-up [0, 0] 2)
          [[0, 1] [0, 2]])
        )
    (is (=
          (to-coordinates [-3, -2] "U2")
          [[-3, -1] [-3, 0]])
        )
    )
  (testing "calculates coordinates for moving down"
    (is (=
          (move-down [0, 0] 2)
          [[0, -1] [0, -2]])
        )
    (is (=
          (to-coordinates [-3, -2] "D2")
          [[-3, -3] [-3, -4]])
        )
    )
  (testing "calculates coordinates for a line"
    (is (=
          (line-to-coordinates [0, 0] ["R1", "U1", "R1", "U1"] [])
          [[1, 0] [1, 1], [2, 1], [2, 2]])
        )
    )
  (testing "coordinates to maps"
    (is (=
          (to-map [1, 1])
          {"1|1" {:x 1 :y 1}}
          )
        )
    )

  (testing "finds common items in 2 lists"
    ;(is (=
    ;      (common [1, 3, 5] [5, 6, 7])
    ;      [5]
    ;      )
    ;    )
    ;  (is (=
    ;        (common [[1, 1], [3, 2], [5, 2]] [[5, 2], [6, 1], [7, 7], [1, 1]])
    ;        [[1 1], [5 2]]
    ;        )
    ;      )
    )
  (testing "computes manhattan distance"
    (is (=
          (manhattan-distance [3, 5])
          8
          )
        )
    )
  ;(testing "find closest intersection"
  ;  (is (=
  ;        (find-closest-intersection
  ;          ["R75", "D30", "R83", "U83", "L12", "D49", "R71", "U7", "L72"]
  ;          ["U62", "R66", "U55", "R34", "D71", "R55", "D58", "R83"])
  ;        159
  ;        )
  ;      )
  ;  (is (=
  ;        (find-closest-intersection
  ;          ["R98", "U47", "R26", "D63", "R33", "U87", "L62", "D20", "R33", "U53", "R51"]
  ;          ["U98", "R91", "D20", "R16", "D67", "R40", "U7", "R15", "U6", "R7"])
  ;        135
  ;        )
  ;      )
  ;  )

  )

(ns advent-of-code-2019.day03-test
  (:require [clojure.test :refer :all])
  (:require [advent-of-code-2019.day03 :refer :all]))

(deftest move-left-test
  (testing "calculate moves"
    (is (=
          (move-left {:x 0 :y 0 :length 0} 2)
          [{:x -1 :y 0 :length 1} {:x -2 :y 0 :length 2}])
        )
    (is (=
          (move-left {:x 0 :y -2 :length 2} 2)
          [{:x -1 :y -2 :length 3} {:x -2 :y -2 :length 4}])
        )
    (is (=
          (move-left {:x -3 :y -2 :length 5} 2)
          [{:x -4 :y -2 :length 6} {:x -5 :y -2 :length 7}])
        )
    (is (=
          (move-right {:x 0 :y 0 :length 0} 2)
          [{:x 1 :y 0 :length 1} {:x 2 :y 0 :length 2}])
        )
    (is (=
          (move-up {:x 0 :y 0 :length 0} 2)
          [{:x 0 :y 1 :length 1} {:x 0 :y 2 :length 2}])
        )
    (is (=
          (move-down {:x 0 :y 0 :length 0} 2)
          [{:x 0 :y -1 :length 1} {:x 0 :y -2 :length 2}])
        )
    )
  (testing "calculates coordinates"
    (is (=
          (to-coordinates {:x -3 :y -2 :length 5} "L2")
          [{:x -4 :y -2 :length 6} {:x -5 :y -2 :length 7}])
        )
    (is (=
          (to-coordinates {:x -3, :y -2 :length 5} "D2")
          [{:x -3 :y -3 :length 6} {:x -3 :y -4 :length 7}])
        )

    (is (=
          (to-coordinates {:x -3, :y -2 :length 5} "D2")
          [{:x -3 :y -3 :length 6} {:x -3 :y -4 :length 7}])
        )
    (is (=
          (to-coordinates {:x -3, :y -2 :length 5} "D2")
          [{:x -3 :y -3 :length 6} {:x -3 :y -4 :length 7}])
        )
    )
  (testing "calculates coordinates for a line"
    (is (=
          (line-to-coordinates {:x 0 :y 0 :length 0} ["R1", "U1", "R1", "U1"] [])
          [{:x 1 :y 0 :length 1} {:x 1 :y 1 :length 2}, {:x 2 :y 1 :length 3}, {:x 2 :y 2 :length 4}])
        )
    )

  (testing "add hash key"
    (is (=
          (add-key {:x 1 :y 0 :length 1})
          {"1|0" {:x 1 :y 0 :length 1}}
          )
        )
    )

  (testing "transforms array to map"
    (is (=
          (to-map [{:x 1 :y 0 :length 1} {:x 1 :y 1 :length 2}])
          {"1|0" {:x 1 :y 0 :length 1} "1|1" {:x 1 :y 1 :length 2}}
          )
        )
    )

  (testing "finds common items in 2 lists"
    (is (=
          (common [{:x 1 :y 0 :length 1} {:x 1 :y 1 :length 2}]
                  [{:x 1 :y 1 :length 12}])
          [[{:x 1 :y 1 :length 2}, {:x 1 :y 1 :length 12}]]
          )
        )
    (is (=
          (common [{:x 1 :y 0 :length 1} {:x 1 :y 1 :length 2} {:x 1 :y 3 :length 21}]
                  [{:x 1 :y 0 :length 9} {:x 1 :y 1 :length 12}])
          [[{:x 1 :y 0 :length 1} {:x 1 :y 0 :length 9}] [{:x 1 :y 1 :length 2}, {:x 1 :y 1 :length 12}]]
          )
        )
    )

  (testing "computes manhattan distance"
    (is (=
          (manhattan-distance {:x 2 :y 1 :length 88})
          3
          )
        )
    )

  (testing "find closest intersection"
    (is (=
          (find-closest-intersection
            ["R75", "D30", "R83", "U83", "L12", "D49", "R71", "U7", "L72"]
            ["U62", "R66", "U55", "R34", "D71", "R55", "D58", "R83"])
          159
          )
        )
    (is (=
          (find-closest-intersection
            ["R98", "U47", "R26", "D63", "R33", "U87", "L62", "D20", "R33", "U53", "R51"]
            ["U98", "R91", "D20", "R16", "D67", "R40", "U7", "R15", "U6", "R7"])
          135
          )
        )
    )

  )

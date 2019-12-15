(ns advent-of-code-2019.day02
  (:require [advent-of-code-2019.day01 :as day01]))

(def program-code [1, 0, 0, 3, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 10, 1, 19, 2, 9, 19, 23, 2, 13, 23, 27, 1, 6, 27, 31, 2, 6, 31, 35, 2, 13, 35, 39, 1, 39, 10, 43, 2, 43, 13, 47, 1, 9, 47, 51, 1, 51, 13, 55, 1, 55, 13, 59, 2, 59, 13, 63, 1, 63, 6, 67, 2, 6, 67, 71, 1, 5, 71, 75, 2, 6, 75, 79, 1, 5, 79, 83, 2, 83, 6, 87, 1, 5, 87, 91, 1, 6, 91, 95, 2, 95, 6, 99, 1, 5, 99, 103, 1, 6, 103, 107, 1, 107, 2, 111, 1, 111, 5, 0, 99, 2, 14, 0, 0])

(defn add [input parameter]
  {:finished false
   :input    (assoc input
               (:target-position parameter)
               (+ (:operand1 parameter) (:operand2 parameter)))}
  )

(defn multiply [input parameter]
  {:finished false
   :input    (assoc input
               (:target-position parameter)
               (* (:operand1 parameter) (:operand2 parameter)))}
  )

(defn halt [input]
  {:finished true
   :input    input}
  )

(defn extract-parameter [input start-position]
  {:operand1        (nth input (nth input (+ start-position 1)))
   :operand2        (nth input (nth input (+ start-position 2)))
   :target-position (nth input (+ start-position 3))}
  )

(defn calculate [input start-position]
  (let [operator (nth input start-position)]
    (case operator
      1 (add input (extract-parameter input start-position))
      2 (multiply input (extract-parameter input start-position))
      99 (halt input)
      )
    )
  )

(defn stepping-recursive [input start-position]
  (let [result (calculate input start-position)]
    (if (= (:finished result) true)
      result
      (stepping-recursive (:input result) (+ start-position 4))
      )
    )
  )

(defn stepping [input]
  (stepping-recursive input 0)
  )

(def restore-state
  (-> program-code
      (assoc 1 12)
      (assoc 2 2)
      )
  )

(def result-program-code
  (println "result part1:" (stepping restore-state)))



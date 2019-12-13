(ns advent-of-code-2019.day01
  (:require [clojure.string :as str]))

(def get-lines
  (map #(Integer/parseInt %) (str/split-lines (slurp "resources/day01-input"))))

(defn calculate-fuel
  [mass]
  (int (- (Math/floor (/ mass 3)) 2)))

(def calculate-total-fuel
  (reduce + (map calculate-fuel get-lines)))

(defn mobule-with-all-fuel
  [mass]
  (let [fuel (day01/calculate-fuel mass)]
    (if (< fuel 0)
      mass
      (recur (+ mass fuel)))))

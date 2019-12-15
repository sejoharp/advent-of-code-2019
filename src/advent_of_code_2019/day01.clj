(ns advent-of-code-2019.day01
  (:require [clojure.string :as str]))

(def load-module-masses
  (map #(Integer/parseInt %) (str/split-lines (slurp "resources/day01-input"))))

(defn calculate-fuel
  [mass]
  (int (- (Math/floor (/ mass 3)) 2)))

(def calculate-total-fuel
  (println "result part1:" (reduce + (map calculate-fuel load-module-masses))))

(defn calculate-fuel-for-mobule
  [fuel-sum remaining-weight]
  (let [fuel (calculate-fuel remaining-weight)]
    (if (< fuel 0)
      fuel-sum
      (calculate-fuel-for-mobule (+ fuel-sum fuel) fuel)
      )
    )
  )

(defn fuel-for-modul
  [weight]
  (calculate-fuel-for-mobule 0 weight))

(def total-fuel-for-all-modules
  (println "result part2:" (reduce + (map fuel-for-modul load-module-masses))))
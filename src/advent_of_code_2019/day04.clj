(ns advent-of-code-2019.day04
  (:require [clojure.string :as strings]))

(def double-digits ["11" "22" "33" "44" "55" "66" "77" "88" "99"])
(def illegal-digits ["111111" "222222" "333333" "444444" "555555" "666666" "777777" "888888" "999999"
                     "1111" "2222" "3333" "4444" "5555" "6666" "7777" "8888" "9999" "0000"
                     "111" "222" "333" "444" "555" "666" "777" "888" "999" "000"])

(defn find-first-double-digit [double-digits number]
  (let [[double-digit & remaining] double-digits]
    (cond
      (empty? double-digits) false
      (strings/includes? number double-digit) true
      :else (find-first-double-digit remaining number))
    )
  )

(defn twice-digit [number]
  (find-first-double-digit double-digits number))

(defn smaller [number-string]
  (let [first (str (first number-string))
        second (str (second number-string))]
    (>
      (Integer/parseInt first)
      (Integer/parseInt second))
    )
  )

(defn find-growing-digits [number-string]
  (if (<= (count number-string) 1)
    true
    (if (smaller number-string)
      false
      (find-growing-digits (rest number-string))
      )
    )
  )

(defn growing-digits [number]
  (find-growing-digits (str number))
  )

(defn find-passwords-part1 [start end]
  (->> (range start end)
       (map str)
       (filter twice-digit)
       (filter growing-digits)
       (count)
       )
  )

(def solution-part1 (find-passwords-part1 402328 864247))

(defn remove-illegal-digits-recur [password illegal-digits]
  (if (empty? illegal-digits)
    password
    (let [illegal-digit (first illegal-digits)]
      (if (strings/includes? password illegal-digit)
        (remove-illegal-digits-recur (strings/replace password illegal-digit "") (rest illegal-digits))
        (remove-illegal-digits-recur password (rest illegal-digits))
        )
      )
    )
  )

(defn
  remove-illegal-digits [passwords]
  (for [password passwords]
    (remove-illegal-digits-recur password illegal-digits)
    )
  )

(defn find-passwords-part2 [start end]
  (->> (range start end)
       (map str)
       (filter growing-digits)
       (remove-illegal-digits)
       (filter twice-digit)
       (count)
       )
  )

(def solution-part2 (find-passwords-part2 402328 864247))
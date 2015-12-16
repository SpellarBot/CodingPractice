(ns test)
(remove-ns 'test)
(ns test)

;---------------------
; 1.2.6 연습 : 소수 찾기
;---------------------

; 약수 찾기

(defn square [n] (* n n))

(defn divides? [a b]
  (= (mod b a) 0))

(defn find-divisor [n test-divisor]
  (cond (> (square test-divisor) n) n
        (divides? test-divisor n) test-divisor
        :else (find-divisor n (+ test-divisor 1))))

(defn smallest-divisor [n]
  (find-divisor n 2))

(defn prime? [n]
  (= n (smallest-divisor n)))

(prime? 5)


; 페르마 검사

(defn expmod [base exp m]
  (cond (= exp 0) 1
        (even? exp) (mod (square (expmod base (/ exp 2) m))
                         m)
        :else (mod (* base (expmod base (- exp 1) m))
                   m)))

(expmod 1 1 1)
(expmod 1 1 2)
(expmod 1 1 3)

(mod 3 2)

(map (fn [x] [x (expmod 10 1 x)]) (range 1 11))

(defn fermat-test [n]
  (defn try-it [a]
    (= (expmod a n n) a))
  (try-it (+ 1 (rand-int (- n 1)))))

(defn fast-prime? [n times]
  (cond (= times 0) true
        (fermat-test n) (fast-prime? n (- times 1))
        :else false))


;---------------------
; 연습문제 1-21
;---------------------

(smallest-divisor 199)
; => 199
(smallest-divisor 1999)
; => 1999
(smallest-divisor 19999)
; => 7

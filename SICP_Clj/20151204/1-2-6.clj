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


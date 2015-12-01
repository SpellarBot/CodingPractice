(ns test)
(remove-ns 'test)
(ns test)

;------------------------------
; 연습문제 1.16
;------------------------------

(defn square [n]
  (* n n))

(defn fe-iter [a b n]
  (cond (= n 0) a
        (even? n) (fe-iter a (square b) (/ n 2))
        :else (fe-iter (* a b) b (- n 1))))

(defn fast-expt [b n]
  (fe-iter 1 b n))

(fast-expt 2 3)
(fast-expt 2 10)


;------------------------------
; 연습문제 1.17
;------------------------------

(defn * [a b]
  (if (= b 0)
    0
    (+ a (* a (- b 1)))))

(defn double [n]
  (+ n n))

(defn halve [n]
  (/ n 2))

(defn * [a b]
  (cond (= b 0) 0
        (even? b) (* (double a) (halve b))
        :else (+ a (* a (- b 1)))))

(* 4 3)
(* 4 4)
(* 4 5)

;------------------------------
; 연습문제 1.18
;------------------------------

(defn times-iter [sum a b]
  (cond (= b 0) sum
        (even? b) (times-iter sum (double a) (halve b))
        :else (times-iter (+ sum a) a (- b 1))))

(defn times [a b]
  (times-iter 0 a b))

(times 3 4)
(times 3 5)
(times 3 6)


;------------------------------
; 연습문제 1.19
;------------------------------

; Ashal's Solution

; 이해가 안됨..

(defn fib-iter [a b p q count]
  (cond (= count 0) b
        (even? count) (fib-iter a
                                b
                                (+ (* p p) (* q q))
                                (+ (* 2 p q) (* q q))
                                (/ count 2))
        :else (fib-iter (+ (* b q) (* a q) (* a p))
                        (+ (* b p) (* a q))
                        p
                        q
                        (- count 1))))

(defn fib [n]
  (fib-iter 1 0 0 1 n))

(map fib (range 11))

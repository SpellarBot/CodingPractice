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
  (* 2 n))

(defn halve [n]
  (/ n 2))

(defn times-iter [a b]
  (cond (= b 0) 0
        (even? b) (* (double a) (halve b))
        :else (+ a (* a (- b 1)))))

(defn times [a b]
  (times-iter a b))

(times 4 3)
(times 4 4)
(times 4 5)

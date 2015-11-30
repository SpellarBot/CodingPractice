(ns test)
(remove-ns 'test)
(ns test)

;------------------------------
; 연습문제 1.16
;------------------------------

(defn square [n]
  (* n n))

(defn fast-expt [b n]
  (defn fe-iter [a b n]
    (cond (= n 0) a
          (even? n) (fe-iter a (square b) (/ n 2))
          :else (fe-iter (* a b) b (- n 1)))))

(fast-expt 10 10)
(fast-expt 10 11)


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

(defn times [a b]
  (defn times-iter [z a b]
    (if (= b 0)
      product
      (+ a (times-iter (+ z a) a (- b 1))))))

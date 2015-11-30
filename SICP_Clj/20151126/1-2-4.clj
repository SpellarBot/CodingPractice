(ns test)
(remove-ns 'test)
(ns test)

;-------------------------------
; 1.2.4 거듭제곱
;------------------------------

; linear recursive process

(defn expt [b n]
  (if (= n 0)
    1
    (* b (expt b (- n 1)))))

; linear iterative process

(defn expt-iter [b counter product]
  (if (= counter 0)
    product
    (expt-iter b
               (- counter 1)
               (* b product))))

(defn expt [b n]
  (expt-iter b n 1))


(defn square [n]
  (* n n))

(defn even? [n]
  (= (mod n 2) 0))

(defn fast-expt [b n]
  (cond (= n 0) 1
        (even? n) (square (fast-expt b (/ n 2)))
        :else (* b (fast-expt b (- n 1)))))




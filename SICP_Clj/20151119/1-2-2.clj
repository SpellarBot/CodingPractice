(ns test)
(remove-ns 'test)
(ns test)

;------------------------------------------------
; 1.2.2 여러 갈래로 되도는 프로세스
;------------------------------------------------

(defn fib [n]
  (cond (= n 0) 0
        (= n 1) 1
        :else (+ (fib (- n 1))
                 (fib (- n 2)))))

(fib 7)


;a <- a + b
;b <- a
(defn fib [n]
  (fib-iter [1 0 n]))

(defn (fib-iter a b count)
  (if (= count 0)
    b
    (fib-iter (+ a b) a (- count 1))))

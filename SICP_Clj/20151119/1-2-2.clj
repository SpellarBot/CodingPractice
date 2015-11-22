(ns test)
(remove-ns 'test)
(ns test)

;------------------------------------------------
; 1.2.2 여러 갈래로 되도는 프로세스
;------------------------------------------------

;---------------
; 재귀 Recursive
;---------------
(defn fib [n]
  (cond (= n 0) 0
        (= n 1) 1
        :else (+ (fib (- n 1))
                 (fib (- n 2)))))

(fib 7)

;--------------
; 반복 Iterative
;--------------
;a <- a + b
;b <- a
(defn fib-iter [a b count]
  (if (= count 0)
    b
    (fib-iter (+ a b) a (- count 1))))

(defn fib [n]
  (fib-iter 1 0 n))


(fib 7)

;----------------------
; 연습 : 돈 바꾸는 방법
;----------------------

(defn first-denomination [kinds-of-coins]
  (cond (= kinds-of-coins 1) 1
        (= kinds-of-coins 2) 5
        (= kinds-of-coins 3) 10
        (= kinds-of-coins 4) 25
        (= kinds-of-coins 5) 50))

(defn cc [amount kinds-of-coins]
  (cond (= amount 1) 1
        (or (< amount 0) (= kinds-of-coins 0)) 0
        :else (+ (cc amount
                     (- kinds-of-coins 1))
                 (cc (- amount
                        (first-denomination kinds-of-coins))
                     kinds-of-coins))))

(defn count-charge [amount]
  (cc amount 5))

(count-charge 100)


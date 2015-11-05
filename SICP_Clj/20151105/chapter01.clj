(ns test)
(remove-ns 'test)
(ns test)

; -----------------------------------------------
; 1.2 프로시저와 프로세스
; -----------------------------------------------

;------------------------------------------------
; 1.2.1 되돌거나recursion 반복하는iteration 프로세스
;------------------------------------------------

;----------------------------
; (linear) recursive process
;----------------------------
(defn factorial [n]
  (if (= n 1)
    1
    (* n (factorial (- n 1)))))

(factorial 6)
; => 720

;--------------------------------
; (linear) iterative process - 1
;--------------------------------
(defn factorial [n]
  (fact-iter 1 1 n))

(defn fact-iter [product counter max-count]
  (if (> counter max-count)
    product
    (fact-iter (* product counter) (+ counter 1) max-count)))

(factorial 6)
; => 720

;--------------------------------
; (linear) iterative process - 2
;--------------------------------
(defn factorial-iter [n]
  (defn iter [product counter]
    (if (> counter n)
      product
      (iter (* counter product)
            (+ counter 1))))
  (iter 1 1))

(factorial-iter 6)
; => 720


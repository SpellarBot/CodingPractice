(ns test)
(remove-ns 'test)
(ns test)

;---------------
; 유클리드 알고리즘
;---------------

(defn gcd [a b]
  (if (= b 0)
    a
    (gcd b (mod a b))))


;---------------
; 연습문제 1.20
;---------------

; 정의 대로 계산
;(gcd 206                                     40)
;(gcd 40                                      (mod 206 40))
;(gcd (mod 206 40)                            (mod 40 (mod 206 40)))
;(gcd (mod 40 (mod 206 40))                   (mod (mod 206 40) (mod 40 (mod 206 40))))
;(gcd (mod (mod 206 40) (mod 40 (mod 206 40)) (mod (mod 40 (mod 206 40)) (mod (mod 206 40) (mod 40 (mod 206 40))))))
; => 21번

; 인자 먼저 계산
;    (gcd 206 40)
; 1. (gcd 40 6)
; 2. (gcd 6 4)
; 3. (gcd 4 2)
; 4. (gcd 2 0)
; => 4번

; Ashal's Solution

(def counter (atom 0))

(defn remainder [a b]
  (swap! counter inc)
  (mod a b))

(defn gcd [a b]
  (if (= b 0)
    a
    (gcd b (remainder a b))))

(reset! counter 0)
(gcd 206 40)
counter

(defn gcd [a b]
  (if (= (b) 0)
    a
    (gcd (b) #(-> (remainder a (b))))))

(reset! counter 0)
(gcd 206 #(-> 40))
counter

; https://clojuredocs.org/clojure.core/defmacro

(defmacro gcd [a b]
  `(if (= ~b 0)
     ~a
     (eval '(gcd ~b (remainder ~a ~b)))))

(reset! counter 0)
(gcd 206 40)
counter

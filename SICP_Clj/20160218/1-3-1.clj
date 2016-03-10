(ns test)
(remove-ns 'test')
(ns test)

;---------------------------------------
; 1.3 차수 높은 프로시저로 요약하는 방법
;---------------------------------------

;---------------------------------------
; 1.3.1 프로시저를 인자로 받는 프로시저
;---------------------------------------

; 1
(defn sum-integers [a b]
  (if (> a b)
    0
    (+ a (sum-integers (+ a 1) b))))

(sum-integers 1 10)

; 2
(defn cube [a]
  (* a a a))

(defn sum-cubes [a b]
  (if (> a b)
    0
    (+ (cube a) (sum-cubes (+ a 1) b))))

(sum-cubes 1 3)

; 3
(defn pi-sum [a b]
  (if (> a b)
    0
    (+ (/ 1.0 (* 2 (+ a 2))) (pi-sum (+ a b) b))))

(defn <name> [a  b]
  (if (> a b)
    0
    (+ (<term> a)
       (<term> (<next> a b)))))

; 4
(defn next [a]
  (+ a 1))

(defn sum [term a next b]
  (if (> a b)
    0
    (+ (term a)
       (sum term (next a) next b))))

(sum cube 1 next 2)

; 5
(defn inc [n]
  (+ n 1))

(defn sum-cubes-2 [a b]
  (sum cube a inc b))

(sum-cubes-2 1 10)

; 6
(defn indentity [x]
  x)

(defn sum-integers-2 [a b]
  (sum indentity a inc b))

(sum-integers-2 1 10)

; 7
(defn pi-sum-2 [a b]
  (defn pi-term [x]
    (/ 1.0 (* x (+ x 2))))
  (defn pi-next [x]
    (+ x 4))
  (sum pi-term a pi-next b))

(* 8 (pi-sum-2 1 1000))

; 8
(defn integral [f a b dx]
  (defn add-dx [x] (+ x dx))
  (* (sum f (+ a (/ dx 2.0)) add-dx b)
     dx))

(integral cube 0 1 0.01)

(integral cube 0 1 0.001)




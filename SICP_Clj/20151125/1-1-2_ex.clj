(ns test)
(remove-ns 'test)
(ns test)

;------------------------------------------------
; 연습문제 1.11
;------------------------------------------------

; Recursive

(defn sumAll [a b c]
  (+ (+ a b) c))

(defn ex11ex [n]
  (cond (< n 3) n
        :else (sumAll (ex11ex (- n 1))
                      (* 2 (ex11ex (- n 2)))
                      (* 3 (ex11ex (- n 3))))))

(ex11ex 4)
; 11

; Iterative
; ...

; Ashal's Solution

(defn f [n]
  (if (< n 3)
    n
    (+ (f (- n 1))
       (* 2 (f (- n 2)))
       (* 3 (f (- n 3))))))

(map f [0 1 2 3 4 5 6 7 8 9 10])

(defn f [n]
  (defn iter [a b c count]
    (if (= count 0)
      a
      (iter b
            c
            (+ c (* 2 b) (* 3 a))
            (- count 1))))
  (iter 0 1 2 n))

(map f [0 1 2 3 4 5 6 7 8 9 10])


;------------------------------------------------
; 연습문제 1.12 (Ashal's Solution)
;------------------------------------------------

(defn pascals-triangle [x y]
  (if (or (= x 0) (= y 0) (= x y))
    1
    (+ (pascals-triangle (- x 1) (- y 1))
       (pascals-triangle x (- y 1)))))

(pascals-triangle 2 4)
(map (fn [x] (pascals-triangle x 1)) (range 2))
(map (fn [x] (pascals-triangle x 2)) (range 3))
(map (fn [x] (pascals-triangle x 3)) (range 4))
(map (fn [x] (pascals-triangle x 4)) (range 5))
(map (fn [x] (pascals-triangle x 5)) (range 6))

;------------------------------------------------
; 연습문제 1.13 (Ashal's Solution)
;------------------------------------------------
(defn fib [n]
  (cond (= n 0) 0
        (= n 1) 1
        :else (+ (fib (- n 1))
                 (fib (- n 2)))))

(def phi (/ (+ 1 (Math/sqrt 5)) 2))

(def psi (/ (- 1 (Math/sqrt 5)) 2))

(defn f [n]
  (/ (Math/pow phi n) (Math/sqrt 5)))

(defn g [n]
  (/ (- (Math/pow phi n) (Math/pow psi n)) (Math/sqrt 5)))

(defn diff [a b]
  (Math/abs (- a b)))

(every? (fn [x] (<= (diff (fib x) (f x)) 0.5)) (range 50))
(every? (fn [x] (<= (diff (fib x) (g x)) 0.001)) (range 50))

; 황금비 (p.50)

(format "%.10f" (- phi 1.6180))
(- (Math/pow phi 2) (+ phi 1))

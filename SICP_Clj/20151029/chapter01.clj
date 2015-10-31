; -----------------------------------------------
; 1.1.7 연습 : 뉴튼 법 newton method 으로 제곱근 찾기
; -----------------------------------------------

(defn average [x y]
  (/ (+ x y) 2))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn square [x] (* x x))

(defn abs [x]
  (if (>= x 0)
    x
    (- x)))

(defn good-enough? [guess x]
  (< (abs (- (square guess) x)) 0.001))

(defn sqrt-iter [guess x]
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x)
               x)))

(defn sqrt [x]
  (sqrt-iter 1.0 x))


(sqrt 9)

(sqrt (+ 100 37))

(sqrt (+ (sqrt 2) (sqrt 2)))

(square (sqrt 1000))
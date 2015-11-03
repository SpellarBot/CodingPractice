(ns test)
(remove-ns 'test)
(ns test)

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


; -----------------------------------------------
; -------------- 스터디 모임 이후 -------------------
; -----------------------------------------------

; -----------------------------------------------
; 연습문제 1.6
; -----------------------------------------------

(defn new-if [predicate then-clause else-clause]
  (cond predicate then-clause
        :else else-clause))

(new-if (= 2 3) 0 5)

(new-if (= 1 1) 0 5)

(defn error-sqrt-iter [guess x]
  (new-if (good-enough? guess x)
          guess
          (error-sqrt-iter (improve guess x) x)))

(error-sqrt-iter 1.0 9)

; java.lang.StackOverflowError: null
; => new-if가 프로시저라 인자 먼저 계산을 하기 때문에 else-clause 무한루프에 빠짐.


; -----------------------------------------------
; 연습문제 1.7
; -----------------------------------------------

(defn new-good-enough? [guess x old]
  (< (abs (- 1 (/ guess old)))
     0.001))

(defn new-sqrt-iter [guess x old]
  (if (new-good-enough? guess x old)
    guess
    (new-sqrt-iter (improve guess x)
                   x
                   guess)))

(def small (square 0.00000001))
(format "%.10f" (sqrt-iter 1.0 small))
(format "%.10f" (new-sqrt-iter 1.0 small small))

(def large (+ (square 9999999) 9))
; (sqrt-iter 1.0 large)
; => StackOverflowError
(new-sqrt-iter 1.0 large large)


; -----------------------------------------------
; 연습문제 1.8
; -----------------------------------------------

(defn cube-root-improve [guess x]
  (/ (+ (/ x
           (square guess))
        (* 2 guess))
     3))

(defn cube-root-iter [guess x old]
  (if (new-good-enough? guess x old)
    guess
    (cube-root-iter (cube-root-improve guess x)
                     x
                     guess)))

(defn cube-root [x]
  (cube-root-iter 1.0 x x))

(defn cube [x]
  (* x x x))

(cube-root (cube 3))
(cube-root (cube -1234567))
(format "%.10f" (cube-root (cube 0.00001)))



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




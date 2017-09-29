;;;==============================================================================================================================================================================================================================
;;;		NAME: add-1-all
;;;	 ARG (s): any list
;;;  RETURNS:

(defun add-1-all (L)		;Take a list as an arg
	"Add 1 to every element of list"
	(cond
		((not (listp L)) nil)
		((endp L) nill) 	;Check if the list is null
		((check-numbers L) ;Calls the check-numbers function
		(cons (1+ (first L))(add-1-all(rest L)))))) ;cons the resilt of 1 + first list
													;element with recursive call
													;on the rest of L
													
;;;==============================================================================================================================================================================================================================
;;;		NAME: check-numbers
;;;	 ARG (s): any list
;;;  RETURNS: true if every element of the list is a number and false if not

(defun check-numbers (L) 
	"Verifies that every element of L is a number"
	(cond
		((endp L) t)					
		((not (numberp (first L))) nil)	;Check if the first element of L is a number
		(t (check-numbers (rest L)))))

;;;==============================================================================================================================================================================================================================
;;;		NAME: my-replace
;;;	 ARG (s): two values and a list
;;;  RETURNS: A list where all occurrences of e1 is replaced with e2

(defun my-replace (e1 e2 L)
	"Returns a new version of L where e1 is replaced with e2"
	(cond
		((null L) nil)
		((listp (first L))
			(if (equal e1 (first L))
				(cons e2 (my-replace e1 e2 (rest L)))							;cons e2 onto recursive call on rest L
			(if (member e1 (first L) :test #'equal)								
			(if (equal e1 (first (first L)))
				(cons (cons e2 (my-replace e1 e2 (rest (first L))))				;cons e1 and call my-replace
					  (my-replace e1 e2 (rest L)))								;on rest of first L. cons that to rest L
			(cons (cons (first (first L)) (my-replace e1 e2 (rest (first L))))
				  (my-replace e1 e2 (rest L))))
			(cons (first L) (my-replace e1 e2 (rest L))))))
			((equal e1 (first L))
				  (cons e2 (my-replace e1 e2 (rest L))))
			(t (cons (first L) (my-replace e1 e2 (rest L))))))
			
;;;==============================================================================================================================================================================================================================
;;;		NAME: fibonacci
;;;	 ARG (s): any number
;;;  RETURNS: the n(th) value in the Fibonacci sequence

(defun fibonacci (n)
	"Returns the n(th) value in the Fibonacci sequence"
	(cond 
		((eq n 1) 0) 
		((eq n 2) 1)
		(t (+ (fibonacci (- n 1)) (fibonacci (- n 2))))))
		
;;;==============================================================================================================================================================================================================================
;;;		NAME: fibonacci-TR
;;;	 ARG (s): any number
;;;  RETURNS: a call to the fibonacci-aux which performs the necessary fibonacci calculations

(defun fibonacci-TR (n)
	"Set fibonacci-aux parameters to 0 1 n, respectively"
	(fibonacci-aux 0 1 ))
	
;;;==============================================================================================================================================================================================================================
;;;		NAME: fibonacci-aux
;;;	 ARG (s): three numbers
;;;  RETURNS: the n(th) value in the Fibonacci sequence

(defun fibonacci-aux (a b n)
	(if (= n 1)
		a
		(fibonacci-aux (+ a b) a (- n 1))))
























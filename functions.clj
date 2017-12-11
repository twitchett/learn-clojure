;; Doing this
;; https://clojure.org/guides/learn/functions

;; 1) Define a function greet that takes not arguments and prints "Hello". Replace the _ with the implementation: (defn greet [] _)
(defn greet [] (println "Hello"))

;; 2) Redefine greet using def, first with the fn special form and then with the #() reader macro.
(def greet (fn [] (println "Hello")))
#(println "Hello")

;; 3) Define a function greeting which:
    ; Given no arguments, returns "Hello, World!"
    ; Given one argument x, returns "Hello, x!"
    ; Given two arguments x and y, returns "x, y!"
(defn greeting
    ([]         "Hello, World!")
    ([x]        (str "Hello, " x "!"))
    ([x, y]     (str x ", " y "!")))

;; 4) Define a function do-nothing which takes a single argument x and returns it, unchanged.
(defn do-nothing [x] x)

;; 5) Define a function always-thing which takes any number of arguments, ignores all of them, and returns the keyword :thing.
(defn always-thing [& args] :thing)

;; 6) Define a function make-thingy which takes a single argument x. It should return another function, which takes any number of arguments and always returns x.
(defn make-thingy [x] (fn [& args] x))

;; 7) Define a function triplicate which takes another function and calls it three times, without any arguments.
(defn triplicate [f] (f) (f) (f)) ;; there's probably a better way

;; 8) Define a function opposite which takes a single argument f. It should return another function which takes any number of arguments, applies f on them, and then calls not on the result. The not function in Clojure does logical negation.
(defn opposite [f] (fn [& args] (not (apply f args))))

;; 9) Define a function triplicate2 which takes another function and any number
;; of arguments, then calls that function three times on those arguments. Re-use
;; the function you defined in the earlier triplicate exercise.
;; -- not working :(
(defn triplicate2 [f & args] (triplicate (fn [] f args)))
(defn triplicate2 [f & args] (triplicate #(f args)))

;; 10
(. Math (cos Math/PI))

;; 11) Define a function that takes an HTTP URL as a string, fetches that URL from the web, and returns the content as a string.
(import java.net.URL)
(defn get-url [url] 
    (let u (URL. url)
        (slurp (.openStream u))
    )
)

;; 12) Define a function one-less-arg that takes two arguments: * f, a function * x, a value
;; and returns another function which calls f on x plus any additional arguments.
(defn one-less-arg
    [f x]
    (fn [& args] (apply f x args))
)

;; 13) Define a function two-fns which takes two functions as arguments, f and g.
;; It returns another function which takes one argument, calls g on it,
;; then calls f on the result, and returns that.
(def two-fns [f g] (fn [i] (f (g i))))

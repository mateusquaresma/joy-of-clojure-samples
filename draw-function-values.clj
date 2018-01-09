(defn f-values [f xs ys]
	(for [x (range xs) y (range ys)] 
		[x y (rem (f x y) 256)]))

(def frame (java.awt.Frame.))
(.setSize frame 512 512)
(.setVisible frame true)

(def gfx (.getGraphics frame))

(defn clear [g xs ys]
	(.clearRect g 0 0 xs ys))

(defn draw-values [f xs ys]
	(clear gfx xs ys)
	(.setSize frame xs ys)
	(doseq [[x y z] (f-values f xs ys)]
		(.setColor gfx (java.awt.Color. z z z))
		(.fillRect gfx x y 1 1)))
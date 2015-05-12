(ns hello.core
  (:import [org.robovm.apple.uikit UIScreen UIWindow UINavigationController]))

(def window (atom nil))
(defn init []
  (reset! window (UIWindow. (.getBounds (UIScreen/getMainScreen))))
  (let [nav-controller (UINavigationController.)]
    (doto @window
      (.setRootViewController nav-controller)
      .makeKeyAndVisible)))

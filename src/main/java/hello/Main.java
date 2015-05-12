package hello;

import clojure.lang.RT;
import clojure.lang.Symbol;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationLaunchOptions;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;

public class Main extends UIApplicationDelegateAdapter {
	public boolean didFinishLaunching(UIApplication app, UIApplicationLaunchOptions opts) {
		RT.var("clojure.core", "require").invoke(Symbol.intern("hello.core"));
		RT.var("hello.core", "init").invoke();
		return true;
	}

	public static void main(String[] args) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(args, null, Main.class);
		pool.close();
	}
}

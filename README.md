This is a little Clojure/RoboVM project designed to demonstrate
the issue described at https://github.com/robovm/robovm/issues/903.
It's been purposely configured with too little memory in gradle.properties,
to show how RoboVM will swallow up certain error messages when a
license is activated.

### Steps to reproduce:

1. `rm -r ~/.robovm/cache`
1. `gradle -i -stacktrace build launchIPhoneSimulator`

### Results

If a RoboVM license is activated:
```
:launchIPhoneSimulator FAILED
... snip ...
Caused by: java.lang.IllegalArgumentException: Line number must not be < 1
```

If a RoboVM license is not activated:
```
:launchIPhoneSimulator FAILD
... snip ...
Caused by: java.lang.OutOfMemoryError: Java heap space
```

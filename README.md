# kotlin-mapping-samples
Practical data mapping samples for Kotlin

These samples illustrate different ways of mapping classes from Source layer to Destination layer. In this example classes of different layers have the same structure: a Person has a Salary.

![Mapping scheme](mapping-scheme.png?raw=true)

## Mapping in class methods
[First sample](MethodMapper.kt)

In the sample Source layer depends on Destination layer and uses classes from this layer. Source layer classes methods do mapping from Source to Destination. Source layer class constructors do mapping from Destination to Source.

Advantages:
- Convenient to reuse: everywhere you have class instance, you have mapper method
- Easy modification: adding some data enclosed in class. You don't need to find separate mapper in your project
- Low code coupling: field of class has private access level

Disadvantages:
- Uncomfortable unit-testing: need to use mock objects for testing mapping methods with inner map calls
- May be forbidden by project architecture

## Mapping in functions
[Second sample](FuncMapper.kt)

Layers hierarchy does not matter. Function `mapPerson` is higher-order function and takes `mapSalary` function as parameter.

Advantages: 
- Convenient to reuse: function without dependencies may be called everywhere in code
- Excellent unit-testing: easy to call mapper function with other test function as arguement

Disadvantages:
- Hard modification: data addition requires modification of class and separate mapper
- Code coupling: open class fields


## Mapping in mapper classes
[Third sample](ClassMapper.kt)

`PersonMapper` depends on `DataMapper<SalarySrc, SalaryDst>` interface, `SalaryMapper` implements this interface.

Same as function mapping, but with several traits.

Advantages: 
- Better code typing: code does not able to use any function as mapper. Mapper clearly defined in the code

Disadvantages:
- More code written

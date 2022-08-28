# Calculator with Java Swing
Calculator built with JDK 11.0.12, Java Swing & [Window Builder bi-directional Java GUI designer](https://www.eclipse.org/windowbuilder/).
## Functionality
- Sum 2 numbers
- Subtract 1 number from another
- Multiply 2 numbers
- Divide 1 number by another
- Check whether a given number is even or odd
## Architecture
| package    | purpose                                                        |
| ---------- | -------------------------------------------------------------- |
| model      | abstract the logic of the calculator                           |
| controller | control both the view and model to bestow the application flow |
## Notes
@wbp.parser.entryPoint annotation in BasicCalculator.java tells Window Builder to use this method code to launch the designer view.
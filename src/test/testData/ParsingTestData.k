import module1
import module2 as asName
import ..pkg.module.sub_module1
import ..pkg.module.sub_module2 as asName

schema Person:
    """schema docstring begin
    schema docstring end"""
    name?: str = "alice"
    age?: int = 5

# The backslash below tells the application to continue reading
# the value onto the next line.
myList = [1, 2, \
3]

alice = Person {
    age: 10
}
schema Person:
    name: str
    $filter: str

alice = Person {
    name: "alice"
    $filter: "some filter"
}

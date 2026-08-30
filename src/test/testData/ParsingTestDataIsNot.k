schema Obj:
    field?: str
    check:
        field is not None
        field is not None, "field must not be None"

schema Range:
    lo: int
    hi: int
    check:
        lo < hi
        lo not in [hi]

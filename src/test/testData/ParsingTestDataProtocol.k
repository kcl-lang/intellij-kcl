schema DataProtocol:
    data: str

schema DataMixin for DataProtocol:
    x: int = data
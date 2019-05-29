package com.realpacific.vehiclemanagement.exceptions


class UserNotFoundException : NotFoundException("User")
class VehicleNotFoundException : NotFoundException("Vehicle")


open class NotFoundException(type: String) : RuntimeException("$type not found.")


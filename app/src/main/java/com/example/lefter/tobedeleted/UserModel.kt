package com.example.lefter.tobedeleted



data class UserModel(var id: Int,
                     var name: String,
                     var username: String,
                     var email: String,
                     var address: UserAddress,
                     var phone: String,
                     var website: String)

data class UserAddress(var street: String,
                       var suite: String,
                       var city: String,
                       var zipcode: String,
                       var geo: UserGeoLocation)

data class UserGeoLocation(var lat: String,
                           var lng: String)

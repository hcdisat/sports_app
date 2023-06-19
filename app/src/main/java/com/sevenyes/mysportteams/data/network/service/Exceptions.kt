package com.sevenyes.mysportteams.data.network.service

class EmptyBodyResponseException: Exception("The response body was empty")
class NotSuccessfulResponseException: Exception("The response was unsuccessful")
package com.example.matheus.chamada.data.model.service

class SessionExpired : RuntimeException("SessionExpired")

class Unexpected : RuntimeException("UnexpectedError")
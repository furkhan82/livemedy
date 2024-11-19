WinWait("Authentication Required - Mozilla Firefox", "", 10)
If WinExists("Authentication Required - Mozilla Firefox") Then
    WinActivate("Authentication Required - Mozilla Firefox")
    ControlSend("Authentication Required - Mozilla Firefox", "", "", "furkan")
	Send("{TAB}")
    ControlSend("Authentication Required - Mozilla Firefox", "", "", "k6W'j{jZKqWaDAErevMyFrk82")
	Send("{ENTER}")
    WinWaitClose("Authentication Required - Mozilla Firefox")
EndIf

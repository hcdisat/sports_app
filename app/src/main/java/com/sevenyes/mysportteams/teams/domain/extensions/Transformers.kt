package com.sevenyes.mysportteams.teams.domain.extensions

import com.sevenyes.mysportteams.data.network.models.Team
import com.sevenyes.mysportteams.teams.domain.models.DomainTeam

fun Team.toDomainTeam() = DomainTeam(
    idLeague = idLeague.orEmpty(),
    idLeague2 = idLeague2.orEmpty(),
    idTeam = idTeam.orEmpty(),
    intFormedYear = intFormedYear.orEmpty(),
    intLoved = intLoved.orEmpty(),
    intStadiumCapacity = intStadiumCapacity.orEmpty(),
    strAlternate = strAlternate.orEmpty(),
    strCountry = strCountry.orEmpty(),
    strDescriptionDE = strDescriptionDE.orEmpty(),
    strDescriptionEN = strDescriptionEN.orEmpty(),
    strDescriptionES = strDescriptionES.orEmpty(),
    strDescriptionFR = strDescriptionFR.orEmpty(),
    strDescriptionNL = strDescriptionNL.orEmpty(),
    strDescriptionNO = strDescriptionNO.orEmpty(),
    strDescriptionPT = strDescriptionPT.orEmpty(),
    strDescriptionRU = strDescriptionRU.orEmpty(),
    strFacebook = strFacebook.orEmpty(),
    strGender = strGender.orEmpty(),
    strInstagram = strInstagram.orEmpty(),
    strKeywords = strKeywords.orEmpty(),
    strKitColour1 = strKitColour1.orEmpty(),
    strKitColour2 = strKitColour2.orEmpty(),
    strKitColour3 = strKitColour3.orEmpty(),
    strLeague = strLeague.orEmpty(),
    strLeague2 = strLeague2.orEmpty(),
    strLeague3 = strLeague3.orEmpty(),
    strLeague4 = strLeague4.orEmpty(),
    strLeague5 = strLeague5.orEmpty(),
    strLeague6 = strLeague6.orEmpty(),
    strLeague7 = strLeague7.orEmpty(),
    strLocked = strLocked.orEmpty(),
    strRSS = strRSS.orEmpty(),
    strSport = strSport.orEmpty(),
    strStadium = strStadium.orEmpty(),
    strStadiumDescription = strStadiumDescription.orEmpty(),
    strStadiumLocation = strStadiumLocation.orEmpty(),
    strStadiumThumb = strStadiumThumb.orEmpty(),
    strTeam = strTeam.orEmpty(),
    strTeamBadge = strTeamBadge.orEmpty(),
    strTeamBanner = strTeamBanner.orEmpty(),
    strTeamFanart1 = strTeamFanart1.orEmpty(),
    strTeamFanart2 = strTeamFanart2.orEmpty(),
    strTeamFanart3 = strTeamFanart3.orEmpty(),
    strTeamFanart4 = strTeamFanart4.orEmpty(),
    strTeamJersey = strTeamJersey.orEmpty(),
    strTeamLogo = strTeamLogo.orEmpty(),
    strTeamShort = strTeamShort.orEmpty(),
    strTwitter = strTwitter.orEmpty(),
    strWebsite = strWebsite.orEmpty(),
    strYoutube = strYoutube.orEmpty()
)
package com.example.sprint.data.repositories

import com.example.sprint.BuildConfig
import com.example.sprint.common.BaseDataSource
import com.example.sprint.data.remote.ApiService
import com.example.sprint.utils.performOperation
import javax.inject.Inject

class Repository @Inject constructor(
    private val apiService: ApiService
) : BaseDataSource() {
    fun getCharacters() = performOperation { getResult { apiService.getAllCharacters() } }

    fun getCharacterDetail(id: Int) = performOperation { getResult { apiService.getCharacter(id) } }


/*
    fun getScores(sport: String, daysFrom: Int) =
        performOperation {
            getResult {
                apiService.getScores(
                    sport,
                    daysFrom,
                    BuildConfig.API_KEY
                )
            }
        }
*/



    fun getOdds( regions: String, markets : String) =
        performOperation {
            getResult {
                apiService.getOdds(
                    regions,
                    markets,
                    BuildConfig.API_KEY
                )
            }
        }


}
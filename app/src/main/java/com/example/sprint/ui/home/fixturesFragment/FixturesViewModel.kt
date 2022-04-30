package com.naylalabs.scorely.ui.main.home.fixturesFragment


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sprint.common.BaseViewModel
import com.example.sprint.data.entities.ScoreModel
import com.example.sprint.data.repositories.Repository
import com.example.sprint.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FixturesViewModel @Inject constructor(private val repository: Repository) :
    BaseViewModel() {

    var page: Int = 0
    private var _date: MutableLiveData<String> = MutableLiveData()

    fun fetchFixtures(): LiveData<Resource<ArrayList<ScoreModel>>> {
        return repository.getScores("soccer_brazil_campeonato", 3)
    }

    /* var fixtures: LiveData<Resource<ArrayList<Fixture>>> = Transformations
         .switchMap(_date) {
             repository.getFixturesByDate(_date, page,LIMIT)
         }*/

    fun setDate(date: String) {
        if (_date.value == date) {
            return
        }
        _date.value = date
    }



    /*   fun listScrolled() {
           page++
           //TODO Biraz kötü bir  seçim oldu gibi ama çalışıyor :), fixtures = repository.getFixturesByDate(_date, page,LIMIT) diyerek apiden veri çekmeye çalıştığımda
           // yukarıda ki fixtures tetiklenmiyor doğal olarak observable çalışmıyor ama bu altta ki kullanımda çalışıyor buna gelince tekrar bakarız istersen
          _date.value = _date.value
       }*/

/*    fun getFixtureLeagues(fixtures: ArrayList<Fixture>): HashMap<League, ArrayList<Fixture>?> {

        val mapByLeague: HashMap<League, ArrayList<Fixture>?> = HashMap()

        repeat(fixtures.size) {

            if (mapByLeague[fixtures[it].league] == null) {
                var list: ArrayList<Fixture> = ArrayList()
                list.add(fixtures[it])
                fixtures[it].league?.let { league -> mapByLeague.put(league, list) }

            } else {
                var list: java.util.ArrayList<Fixture>? = mapByLeague[fixtures[it].league]
                list!!.add(fixtures[it])
                fixtures[it].league?.let { league -> mapByLeague.put(league, list) }
            }
        }
        return mapByLeague

    }*/

    companion object {
        private const val LIMIT = 20
    }

}
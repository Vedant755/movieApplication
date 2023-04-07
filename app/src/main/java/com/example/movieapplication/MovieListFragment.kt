import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapplication.R
import com.example.movieapplication.adapters.MovieAdapter
import com.example.movieapplication.model.MovieList

class MovieListFragment : Fragment() {

    private lateinit var movieAdapter: MovieAdapter
    private lateinit var recyclerView: RecyclerView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_list, container, false)

        // Initialize RecyclerView and adapter
        recyclerView = view.findViewById(R.id.rv_movies)
        movieAdapter = MovieAdapter(MovieList(emptyList()))

        // Set RecyclerView layout and adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = movieAdapter

        return view
    }

    fun setMovies(movies: MovieList) {
        movieAdapter.setData(movies)
    }
}
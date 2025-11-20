import java.util.LinkedList;

/**
 * The RatingsTree class represents a binary search tree of movies based on their ratings.
 */
public class RatingsTree {
    public MovieNode root; // The root node of the rating tree.

    /**
     * Constructs a RatingsTree object with the root set to null.
     */
    public RatingsTree() {
        root = null;
    }

    /**
     * Inserts a new movie into the rating tree.
     *
     * @param name   the name of the movie
     * @param rating the rating of the movie
     * @param genre  the genre of the movie
     */
    public void insert(String name, int rating, String genre) {
        insertRecursive(root, new MovieNode(new Movie(name, rating, genre)));
    }
    /**
     * Recursively inserts a movie node into the rating tree.
     *
     * @param root the root node of the subtree
     * @param node the movie node to be inserted
     * @return the root node of the modified subtree
     */
    private MovieNode insertRecursive(MovieNode root, MovieNode node) {
        if (root == null)
        {
            this.root = node;
            return this.root;
        }

        boolean onleft = node.getValue().getRating() <= root.getValue().getRating();
        MovieNode new_root = onleft? root.getLeft() : root.getRight();
        if (new_root == null) {
            if (onleft) {
                root.setLeft(node);
            } else {
                root.setRight(node);
            }
        }
        else
        {
            return insertRecursive(new_root, node);
        }
        return root;
	}

    
    /**
     * Prints all movies in the rating tree in ascending order of their ratings.
     */
    public void printAll() {
        printAll(root);
    }

    /**
     * Recursively prints all movies in the rating tree in ascending order of their ratings.
     *
     * @param root the root node of the subtree to be printed
     */
    private void printAll(MovieNode root) {
        if (root == null) return;
        printAll(root.getLeft());
        System.out.println(root.getValue().toString());
        printAll(root.getRight());
	}

    /**
     * Finds and prints all movies with a rating equal to or higher than the specified rating.
     *
     * @param rating the minimum rating
     */
    public void findMoviesAtLeast(int rating) {
        LinkedList<Movie> highRatings = new LinkedList<Movie>(findRatingHigher(root, rating));
        System.out.println("All movies with a rating of " + rating + " or higher:");
        for (Movie movie : highRatings) {
            System.out.println("\t" + movie);
        }
    }

    /**
     * Recursively finds movies with a rating equal to or higher than the specified rating.
     *
     * @param root     the root node of the subtree to be searched
     * @param minRating the minimum rating
     * @return a list of movies with ratings equal to or higher than the specified rating
     */
    private LinkedList<Movie> findRatingHigher(MovieNode root, int minRating) {
        if (root == null) return new LinkedList<>();

        LinkedList<Movie> movies;


        if (root.getValue().getRating() < minRating)
        {
            // we need to go higher. only check the left branch for values.
            movies = findRatingHigher(root.getRight(), minRating);
        }
        else 
        {
            // we are higher and are free to check both th left and right branch
            movies = findRatingHigher(root.getLeft(), minRating);
            movies.addAll(findRatingHigher(root.getRight(), minRating));

            // add the root to the beginning.
            movies.addFirst(root.getValue());
        }
        return movies;
	}
	
	 /**
     * Finds and prints all movies with a rating equal to or lower than the specified rating.
     *
     * @param rating the maximum rating
     */
	public void findMoviesLower(int rating) {
        LinkedList<Movie> lowRatings = new LinkedList<Movie>(findRatingLower(root, rating));
        System.out.println("All movies with a rating of " + rating + " or lower:");
        for (Movie movie : lowRatings) {
            System.out.println("\t" + movie);
        }
    }

    /**
     * Recursively finds movies with a rating equal to or lower than the specified rating.
     *
     * @param root     the root node of the subtree to be searched
     * @param maxRating the maximum rating
     * @return a list of movies with ratings equal to or lower than the specified rating
     */
    private LinkedList<Movie> findRatingLower(MovieNode root, int maxRating) {
        if (root == null) return new LinkedList<>();
        LinkedList<Movie> movies;
        if (root.getValue().getRating() > maxRating)
        {
            // we need to go lower. only check the left branch for values.
            movies = findRatingLower(root.getLeft(), maxRating);
        }
        else 
        {
            // we are lower and are free to check both th left and right branch
            movies = findRatingLower(root.getLeft(), maxRating);
            movies.addAll(findRatingLower(root.getRight(), maxRating));

            // add the root to the beginning.
            movies.addFirst(root.getValue());
        }

		return movies;
	}

    /**
     * Finds and prints all movies of the specified genre.
     *
     * @param genre the genre to search for
     */
    public void findAllGenre(String genre) {
        LinkedList<Movie> genreMovies = new LinkedList<Movie>(findGenre(root, genre));
        System.out.println("All " + genreMovies.size() + " movies in the " + genre + " genre:");
        for (Movie movie : genreMovies) {
            System.out.println("\t" + movie);
        }
    }

    /**
     * Recursively finds movies of the specified genre.
     *
     * @param root  the root node of the subtree to be searched
     * @param genre the genre to search for
     * @return a list of movies of the specified genre
     */
    private LinkedList<Movie> findGenre(MovieNode root, String genre) {
        LinkedList<Movie> movies = new LinkedList<>();
        if (root == null) return movies;

        // Check our root for the genre. If it has the same genre add it to the return list
        if (root.getValue().getGenre().equals(genre))
        {
            movies.add(root.getValue());
        }
        
        // recursively search for and append movies with the matching genre in both left and right branches.
        movies.addAll(findGenre(root.getLeft(), genre));
        movies.addAll(findGenre(root.getRight(), genre));

        return movies;
	}

}

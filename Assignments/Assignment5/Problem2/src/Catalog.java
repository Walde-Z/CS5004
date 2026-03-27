import java.util.ArrayList;
import java.util.Locale;

public class Catalog {
  private ArrayList<Item> items;

  public Catalog() {
    this.items = new ArrayList<>();
  }

  public Catalog(ArrayList<Item> items) {
    this.items = items;
  }

  public void addItem(Item item) {
    items.add(item);
  }

  public void removeItem(Item item) {
    items.remove(item);
  }

  public ArrayList<Item> search(String keyword) {
    ArrayList<Item> result = new ArrayList<>();
    for (Item item : items) {
      if (item.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
        result.add(item);
      }
    }
    return result;
  }

  public ArrayList<Item> search(Author author) {
    ArrayList<Item> result = new ArrayList<>();

    for (Item item : items) {
      if (item instanceof Book) {
        Book book = (Book) item;
        if (book.getCreator().equals(author)) {
          result.add(book);
        }
      }
    }
    return result;
  }

  public ArrayList<Item> search(RecordingArtist artist) {
    ArrayList<Item> result = new ArrayList<>();

    for (Item item : items) {
      if (item instanceof Music) {
        Music music = (Music) item;

        if (music.getCreator().equals(artist)) {
          result.add(music);
        }
      }
    }
    return result;
  }
}

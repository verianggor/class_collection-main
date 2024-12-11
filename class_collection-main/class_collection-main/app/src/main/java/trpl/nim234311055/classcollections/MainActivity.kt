package trpl.nim234311055.classcollections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//Tugas 1
data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
)

//Tugas 2
enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING,
}

//Tugas 7
val Event.durationOfEvent: String
    get() = if (this.durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }

@Composable
fun EventList(events: List<Event>) {
    Column(modifier = Modifier
        .padding(16.dp)
        .background(Color.White)) { // Menambahkan latar belakang putih
        events.forEach {
            Text(text = "Event: ${it.title} - Duration: ${it.durationOfEvent}")
        }
    }
}

@Preview
@Composable
fun PreviewEventList() {
    val event1 = Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0)
    val event2 = Event(title = "Bath", daypart = Daypart.MORNING, durationInMinutes = 0)
    val event3 = Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15)
    val event4 = Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30)
    val event5 = Event(title = "Nap", description = "Nap Time", daypart = Daypart.AFTERNOON, durationInMinutes = 30)
    val event6 = Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60)
    val event7 = Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10)
    val event8 = Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)
    val event9 = Event(title = "Sleep at night", daypart = Daypart.EVENING, durationInMinutes = 45)

    val events = listOf(event1, event2, event3, event4, event5, event6, event7, event8, event9)
    EventList(events)
}

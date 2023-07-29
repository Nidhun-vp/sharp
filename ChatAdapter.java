//ChatAdapter.java
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.List;

public class ChatAdapter extends ArrayAdapter<Message> {

    private Context context;
    private List<Message> messages;

    public ChatAdapter(Context context, List<Message> messages) {
        super(context, 0, messages);
        this.context = context;
        this.messages = messages;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        Message message = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(
                    message.isSentByCurrentUser() ? R.layout.item_message_sent : R.layout.item_message_received,
                    parent,
                    false);
        }

        TextView messageTextView = convertView.findViewById(R.id.messageTextView);
        messageTextView.setText(message.getContent());

        return convertView;
    }
}

package fbos;

public abstract class Attachment {

	private int bufferId;
	private boolean isDepthAttach = false;

	public int getBufferId() {
		return bufferId;
	}


	public abstract void init(int attachment, int width, int height, int samples);

	public abstract void delete();

	/**
	 * Sets the ID of the storage being used for this attachment.
	 * 
	 * @param id
	 *            - The ID of either the texture or the render buffer being used
	 *            for this attachment.
	 */
	protected void setBufferId(int id) {
		this.bufferId = id;
	}

	/**
	 * Indicate that this attachment is a depth buffer attachment.
	 */
	protected void setAsDepthAttachment() {
		this.isDepthAttach = true;
	}

	/**
	 * @return True if this attachment is being used as a depth attachment.
	 */
	protected boolean isDepthAttachment() {
		return isDepthAttach;
	}

}
